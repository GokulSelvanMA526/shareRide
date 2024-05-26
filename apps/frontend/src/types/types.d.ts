/* eslint-disable @typescript-eslint/consistent-type-definitions */
export type RootStackParamList = {
  Home: undefined;
  Login: undefined;
  CreateRide: undefined;
  JoinRide: undefined;
};

export type ScreenName = keyof RootStackParamList;
