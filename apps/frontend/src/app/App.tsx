import * as React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import AppNavigator from '../navigation/AppNavigator';
import {PaperProvider} from 'react-native-paper';
import {navigationRef} from '../navigation/RootNavigator';

export default function App() {
  return (
    <NavigationContainer ref={navigationRef}>
      <PaperProvider>
        <AppNavigator initialPage="Login" />
      </PaperProvider>
    </NavigationContainer>
  );
}
