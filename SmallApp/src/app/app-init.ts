import { KeycloakService } from 'keycloak-angular';

export function initializer(keycloak: KeycloakService): () => Promise<any> {
  return (): Promise<any> => {
    return new Promise(async (resolve, reject) => {
      try {
        await keycloak.init(
          {
            config: {
              url: 'https://localhost:8443/auth',
              realm: 'mysecretcorpo',
              clientId: 'account',
            },
            initOptions: {
              onLoad: 'login-required',
              checkLoginIframe: false
            },
            bearerExcludedUrls: [
              '/assets',
              '/clients/public',
              'giphy.com'
            ],
          }
        );
        resolve();
      } catch (error) {
        reject(error);
      }
    });
  };
}
