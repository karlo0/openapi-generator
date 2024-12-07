/*
 * OpenAPI Petstore
 *
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


using System;
using System.Threading.Tasks;
using Newtonsoft.Json;
using RestSharp;
using RestSharp.Authenticators;

namespace Org.OpenAPITools.Client.Auth
{
    /// <summary>
    /// An authenticator for OAuth2 authentication flows
    /// </summary>
    public class OAuthAuthenticator : IAuthenticator
    {
        private TokenResponse _token;

        /// <summary>
        /// Returns the current authentication token. Can return null if there is no authentication token, or it has expired.
        /// </summary>
        public string Token
        {
            get
            {
                if (_token == null) return null;
                if (_token.ExpiresIn == null) return _token.AccessToken;
                if (_token.ExpiresAt < DateTime.Now) return null;

                return _token.AccessToken;
            }
        }

        readonly string _tokenUrl;
        readonly string _clientId;
        readonly string _clientSecret;
        readonly string _scope;
        readonly string _grantType;
        readonly JsonSerializerSettings _serializerSettings;
        readonly IReadableConfiguration _configuration;

        /// <summary>
        /// Initialize the OAuth2 Authenticator
        /// </summary>
        public OAuthAuthenticator(
            string tokenUrl,
            string clientId,
            string clientSecret,
            string scope,
            OAuthFlow? flow,
            JsonSerializerSettings serializerSettings,
            IReadableConfiguration configuration)
        {
            _tokenUrl = tokenUrl;
            _clientId = clientId;
            _clientSecret = clientSecret;
            _scope = scope;
            _serializerSettings = serializerSettings;
            _configuration = configuration;

            switch (flow)
            {
                /*case OAuthFlow.ACCESS_CODE:
                    _grantType = "authorization_code";
                    break;
                case OAuthFlow.IMPLICIT:
                    _grantType = "implicit";
                    break;
                case OAuthFlow.PASSWORD:
                    _grantType = "password";
                    break;*/
                case OAuthFlow.APPLICATION:
                    _grantType = "client_credentials";
                    break;
                default:
                    break;
            }
        }

        /// <summary>
        /// Creates an authentication parameter from an access token.
        /// </summary>
        /// <returns>An authentication parameter.</returns>
        protected async ValueTask<Parameter> GetAuthenticationParameter()
        {
            var token = string.IsNullOrEmpty(Token) ? await GetToken().ConfigureAwait(false) : Token;
            return new HeaderParameter(KnownHeaders.Authorization, token);
        }

        /// <summary>
        /// Gets the token from the OAuth2 server.
        /// </summary>
        /// <returns>An authentication token.</returns>
        async Task<string> GetToken()
        {
            var client = new RestClient(_tokenUrl, configureSerialization: serializerConfig => serializerConfig.UseSerializer(() => new CustomJsonCodec(_serializerSettings, _configuration)));

            var request = new RestRequest();
            if (!string.IsNullOrWhiteSpace(_token?.RefreshToken))
            {
                request.AddParameter("grant_type", "refresh_token")
                    .AddParameter("refresh_token", _token.RefreshToken);
            }
            else
            {
                request
                    .AddParameter("grant_type", _grantType)
                    .AddParameter("client_id", _clientId)
                    .AddParameter("client_secret", _clientSecret);
            }
            if (!string.IsNullOrEmpty(_scope))
            {
                request.AddParameter("scope", _scope);
            }
            _token = await client.PostAsync<TokenResponse>(request).ConfigureAwait(false);
            // RFC6749 - token_type is case insensitive.
            // RFC6750 - In Authorization header Bearer should be capitalized.
            // Fix the capitalization irrespective of token_type casing.
            switch (_token?.TokenType?.ToLower())
            {
                case "bearer":
                    return $"Bearer {_token.AccessToken}";
                default:
                    return $"{_token?.TokenType} {_token?.AccessToken}";
            }
        }

        /// <summary>
        /// Retrieves the authentication token (creating a new one if necessary) and adds it to the current request
        /// </summary>
        /// <param name="client"></param>
        /// <param name="request"></param>
        /// <returns></returns>
        public async ValueTask Authenticate(IRestClient client, RestRequest request)
            => request.AddOrUpdateParameter(await GetAuthenticationParameter().ConfigureAwait(false));
    }
}
