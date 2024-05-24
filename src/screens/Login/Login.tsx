/*

create an login screen with username and passwor input fields and a login button with the following requirements:

- The Login component should be a functional component.
- The Login component should render a View component as the root component.
- The View component should have a style prop with a backgroundColor property set to '#fff'.
- The View component should have two TextInput components as children.
- The TextInput components should have a style prop with a backgroundColor property set to '#fff'.
- The TextInput components should have a style prop with a margin property set to 10.
- The TextInput components should have a style prop with a padding property set to 10.
- The TextInput components should have a style prop with a borderColor property set to '#000'.
- The TextInput components should have a style prop with a borderWidth property set to 1.
- The TextInput components should have a style prop with a borderRadius property set to 5.
- The textinput components should have a placeholder prop with the value 'Username' and 'Password'.
- The Login component should use the react-native-paper library for the TextInput components.
- react-native-paper should be imported from 'react-native-paper'.
- react-native-paper should be used to create the TextInput components.
- react-native-paper should be used to create the Button component.
- create a createStyles function that returns an object with a backgroundColor property set to '#fff'.
- use the createStyles function to set the style prop of the View component.
- use the createStyles function to set the style prop of the TextInput components.
- use the createStyles function to set the style prop of the Button component.
- use the createStyles with naming as box, userInput and password as names for the styles.

*/

// Path: frontend/shareRide/shareRide/src/screens/Login/Login.tsx

import React from 'react';
import {View, TextInput} from 'react-native';
import {Button} from 'react-native-paper';

const Login = () => {
  const createStyles = () => {
    return {
      backgroundColor: '#fff',
      margin: 10,
      padding: 10,
      borderColor: '#000',
      borderWidth: 1,
      borderRadius: 5,
    };
  };

  return (
    <View style={createStyles()}>
      <TextInput style={createStyles()} placeholder="Username" />
      <TextInput style={createStyles()} placeholder="Password" />
      <Button style={createStyles()}>Login</Button>
    </View>
  );
};

export default Login;
