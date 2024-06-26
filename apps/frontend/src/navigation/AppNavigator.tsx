import {createNativeStackNavigator} from '@react-navigation/native-stack';
import React from 'react';
import Home from '../screens/Home/Home';
import type {RootStackParamList, ScreenName} from '../types/types';
import Login from '../screens/Login/Login';
import CreateRide from '../screens/CreateRide/CreateRide';
import FindRide from '../screens/FindRide/FindRide';
import JoinRide from '../screens/JoinRide/JoinRide';
import AddVehicle from '../screens/AddVehicle/AddVehicle';
import SignUp from '../screens/SignUp/SignUp';

const Stack = createNativeStackNavigator<RootStackParamList>();
interface AppProps {
  initialPage: ScreenName;
}

/*
create an AppNavigator component that will be used in the App component with the following requirements:
- The AppNavigator component should be a functional component.
- The AppNavigator component should take an initialPage prop of type ScreenName.
- The AppNavigator component should return a Stack.Navigator component as the root component.
- The Stack.Navigator component should have a screenOptions prop that takes a function that returns an object.
- The screenOptions function should return an object with a headerShown property set to false.
- The ScreenOptions function should hide the header for all screens.
*/

const AppNavigator = ({initialPage}: AppProps) => {
  return (
    <Stack.Navigator
      initialRouteName={initialPage}
      screenOptions={{headerShown: false}}>
      <Stack.Screen name="Home" component={Home} />
      <Stack.Screen name="Login" component={Login} />
      <Stack.Screen name="CreateRide" component={CreateRide} />
      <Stack.Screen name="FindRide" component={FindRide} />
      <Stack.Screen name="JoinRide" component={JoinRide} />
      <Stack.Screen name="AddVehicle" component={AddVehicle} />
      <Stack.Screen name="SignUp" component={SignUp} />
    </Stack.Navigator>
  );
};

export default AppNavigator;
