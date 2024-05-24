/*
Create an Home Component that will be used in the AppNavigator component 
with the following requirements:
- The Home component should be a functional component.
- The Home component should render a View component as the root component.
- The View component should have a style prop with a backgroundColor property set to '#fff'.
- The View component should have a Text component as a child.
- The Text component should have a style prop with a color property set to '#000'.
- The Text component should display the text 'Home'.
*/

// Path: frontend/shareRide/shareRide/src/screens/Home/Home.tsx

// create a button with the text 'Share Ride' and a style prop with a backgroundColor property set to '#fff'.
// create a button with the text 'Find Ride' and a style prop with a backgroundColor property set to '#fff'.
// create a button with the text 'Profile' and a style prop with a backgroundColor property set to '#fff'.
// create a button with the text 'Logout' and a style prop with a backgroundColor property set to '#fff'.

// Path: frontend/shareRide/shareRide/src/screens/Home/Home.tsx

import React from 'react';
import {View, Text} from 'react-native';
import {Button} from 'react-native-paper';
import {navigate} from '../../navigation/RootNavigator';

const Home = () => {
  const handleClick = () => {
    navigate('Login');
  };

  return (
    <View style={{backgroundColor: '#fff'}}>
      <Text style={{color: '#000'}}>Home</Text>
      <Button style={{backgroundColor: '#fff'}} onPress={handleClick}>
        Share Ride
      </Button>
    </View>
  );
};

export default Home;
