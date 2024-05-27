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
import React, {useState} from 'react';
import {View, Text, FlatList, TouchableOpacity, Dimensions} from 'react-native';
import {Appbar, Button, Divider} from 'react-native-paper';
import {Card} from 'react-native-paper';
import Icon from 'react-native-vector-icons/Ionicons';
import {Dropdown} from 'react-native-element-dropdown';
import styles from './Home.styles';
import {navigate} from '../../navigation/RootNavigator';

const Home = () => {
  const [value, setValue] = useState('');
  const [isFocus, setIsFocus] = useState(false);
  // const [selectedLocation, setSelectedLocation] = useState(locations[0]);
  const [isReversed, setIsReversed] = useState(false);
  const windowWidth = Dimensions.get('window').width;

  // Replace this with your actual data
  const pastRides = [
    {id: '1', name: 'Ride 1', date: '2022-01-01 10:00'},
    {id: '2', name: 'Ride 2', date: '2022-01-02 11:00'},
    // ...
  ];

  const locations = [
    {label: 'Location 1', value: '1'},
    {label: 'Location 2', value: '2'},
    {label: 'Location 3', value: '3'},
    // ...
  ];

  // create a function to navigate to the CreateRide screen when the create ride button is pressed and pass the selected dropdown value as a parameter
  const handleCreateRidePress = (selectedValue: string) => {
    navigate('CreateRide', {selectedValue, isReversed});
  };

  // create  a function to navigate to the FindRide screen when the find ride button is pressed and pass the selected dropdown value as a parameter
  const handleFindRidePress = (selectedLocaitonValue: string) => {
    console.log(selectedLocaitonValue, 'selectedValue from function');
    const selectedValue = selectedLocaitonValue; // Declare the selectedValue variable
    navigate('FindRide', {selectedValue, isReversed});
  };

  return (
    <View style={{backgroundColor: '#fff'}}>
      <Appbar.Header>
        <Appbar.Content title="Home" />
        <Appbar.Action icon="dots-vertical" onPress={() => {}} />
      </Appbar.Header>
      <View style={styles.searchArea}>
        {!isReversed ? (
          <>
            <Dropdown
              style={[styles.dropdown, isFocus && {borderColor: 'blue'}]}
              placeholderStyle={styles.placeholderStyle}
              selectedTextStyle={styles.selectedTextStyle}
              inputSearchStyle={styles.inputSearchStyle}
              iconStyle={styles.iconStyle}
              data={locations}
              search
              maxHeight={300}
              labelField="label"
              valueField="value"
              placeholder={!isFocus ? 'Select your Pickup Point' : '...'}
              searchPlaceholder="Search..."
              value={value}
              onFocus={() => setIsFocus(true)}
              onBlur={() => setIsFocus(false)}
              onChange={item => {
                setValue(item.value as string);
                setIsFocus(false);
              }}
              renderLeftIcon={() => (
                <Icon name={'location'} size={20} color="#000" />
              )}
            />
            {/* <Divider /> */}
            <View style={styles.destinationView}>
              <Text style={styles.destinationText}>
                <Icon name={'location'} size={20} color="#000" /> CIEC
              </Text>
            </View>
          </>
        ) : (
          <>
            <View style={styles.destinationView}>
              <Text style={styles.destinationText}>
                <Icon name={'location'} size={20} color="#000" />
                CIEC
              </Text>
            </View>
            {/* <Divider /> */}
            <Dropdown
              style={[styles.dropdown, isFocus && {borderColor: 'blue'}]}
              placeholderStyle={styles.placeholderStyle}
              selectedTextStyle={styles.selectedTextStyle}
              inputSearchStyle={styles.inputSearchStyle}
              iconStyle={styles.iconStyle}
              data={locations}
              search
              maxHeight={300}
              labelField="label"
              valueField="value"
              placeholder={!isFocus ? 'Select your Drop Point' : '...'}
              searchPlaceholder="Search..."
              value={value}
              onFocus={() => setIsFocus(true)}
              onBlur={() => setIsFocus(false)}
              onChange={item => {
                setValue(item.value as string);
                setIsFocus(false);
              }}
              renderLeftIcon={() => (
                <Icon name={'location'} size={20} color="#000" />
              )}
            />
          </>
        )}
        <TouchableOpacity
          style={[
            styles.shuffleIcon,
            {
              top: windowWidth / 13,
            },
          ]}
          onPress={() => setIsReversed(!isReversed)}>
          <Icon name="shuffle" size={24} color="black" />
        </TouchableOpacity>
        <Button
          mode="contained"
          style={{margin: 10}}
          contentStyle={{height: 50}}
          onPress={() => handleFindRidePress(value)}>
          Find Ride
        </Button>
        <Button
          mode="outlined"
          style={{margin: 10}}
          contentStyle={{height: 50}}
          onPress={() => handleCreateRidePress(value)}>
          Create Ride
        </Button>
      </View>
      <View style={{flexDirection: 'row', alignItems: 'center'}}>
        <Text style={{flex: 1, textAlign: 'center'}}>Past Rides</Text>
        <Divider style={{height: '100%', backgroundColor: '#000'}} />
      </View>
      {/* {renderLabel()} */}
      <View>
        <FlatList
          data={pastRides}
          keyExtractor={item => item.id}
          renderItem={({item}) => (
            <Card
              style={[
                styles.item,
                {
                  backgroundColor: 'skyblue',
                  borderColor: 'blue',
                  borderWidth: 2,
                },
              ]}
              theme={{colors: {primary: 'blue'}}}>
              <Card.Content>
                <View style={{flexDirection: 'row', alignItems: 'center'}}>
                  <Icon
                    name={Math.random() > 0.5 ? 'car' : 'bicycle'}
                    size={20}
                    color="#000"
                  />
                  <Text style={{fontSize: 23}}>{item.name}</Text>
                </View>
                <Text style={styles.date}>{item.date}</Text>
              </Card.Content>
              <Card.Actions>
                {/* <Button>Cancel</Button> */}
                <Button>View Details</Button>
              </Card.Actions>
            </Card>
          )}
        />
      </View>
    </View>
  );
};

export default Home;
