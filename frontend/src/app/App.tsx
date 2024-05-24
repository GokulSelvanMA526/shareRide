import * as React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import AppNavigator from '../navigation/AppNavigator';
import {PaperProvider} from 'react-native-paper';

export default function App() {
  return (
    <PaperProvider>
      <NavigationContainer>
        <AppNavigator initialPage="Login" />
      </NavigationContainer>
    </PaperProvider>
  );
}
