import { gateway as MoltinGateway } from '@moltin/sdk';

export const Config = {
  production: false,
  baseImagesUrl: '',
  Moltin: MoltinGateway({
        client_id: 'XXXX'
  })
};
