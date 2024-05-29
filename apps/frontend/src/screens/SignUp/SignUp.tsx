/*
create a signup screen for react native with the following fields:
1. employeeId
2. password
3. confirmPassword
4. signup button

use the elements from react-native and react-native-vector-icons libraries:
1. View
2. Text
3. TextInput
4. Button
5. Icon

follow the given structure:
1. create a container with styles
2. create form container with styles
3. create employeeId input field with styles inside form container and placeholder text as 'Employee ID'
4. create password input field with styles inside form container and placeholder text as 'Password'
5. create confirmPassword input field with styles inside form container and placeholder text as 'Confirm Password'
6. create signup button with styles inside form container and text as 'Signup'
7. create error message with styles below employeeId input field, password input field and confirmPassword input field
8. create success message with styles below signup button
9. create loading indicator with styles below signup button
10. place the form container inside the container and center of the screen
11. create form container background color as grey
12. create a background of the Screen as white
13. create a header above to as Sign Up

use the following state variables:
1. employeeId
2. password
3. confirmPassword

use icon for employeeId, password and confirmPassword input fields:
1. employeeId: <Icon name="employeeId" size={20} color="black" />
2. password: <Icon name="password" size={20} color="black" />
3. confirmPassword: <Icon name="confirmPassword" size={20} color="black" />

use the following functions:
1. setEmployeeId
2. setPassword
3. setConfirmPassword
4. signup

use the following validations:
1. employeeId should be a valid employeeId
2. password should be atleast 6 characters long
3. password and confirmPassword should match
4. show error message if employeeId or password is invalid below the respective input field
5. show error message if signup api fails
6. show loading indicator while api is in progress
7. show success message on successful signup
8. show error message on unsuccessful signup
9. show error message if employeeId or password is empty
10. show error message if employeeId or password is not provided
11. show error message if employeeId or password is not a string
12. employeeId length should be greater than 5
13. show error message if employeeId or password is not provided in request
14. show error message if employeeId or password is not provided in response
15. show error message if employeeId or password is not a string in request
16. show error message if password is left empty in input field and signup is clicked without entering password in input field and vice versa below the password input field

use the following styles:

container: {
  flex: 1,
  justifyContent: 'center',
  alignItems: 'center',
  backgroundColor: 'white',
},
formContainer: {
  width: '80%',
  padding: 10,
  backgroundColor: 'grey',
},
input: {
  borderWidth: 1,
  borderRadius: 5,
  padding: 10,
  margin: 5,
},
error: {
  color: 'red',
},
success: {
  color: 'green',
},
loading: {
  color: 'blue',
},
button: {
  backgroundColor: 'blue',
  padding: 10,
  margin: 5,
  borderRadius: 5,
},


*/

import React, {useState} from 'react';
import {View, Text, TextInput} from 'react-native';
import Icon from 'react-native-vector-icons';
import {Button} from 'react-native-paper';
import {Dropdown} from 'react-native-element-dropdown';

const SignUp = () => {
  const [employeeId, setEmployeeId] = useState('');
  const [name, setName] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [mobileNumber, setMobileNumber] = useState('');
  const [gender, setGender] = useState('');

  const [errorMessage, setErrorMessage] = useState('');
  const [successMessage, setSuccessMessage] = useState('');
  const [isLoading, setIsLoading] = useState(false);

  const genderData = [
    {label: 'Male', value: 'male'},
    {label: 'Female', value: 'female'},
  ];

  const handleSignUp = () => {
    // Perform signup logic here
    // You can use the state variables for validation and API calls

    // Example validation
    if (name === '') {
      setErrorMessage('Name is required');
      return;
    }
    if (employeeId === '') {
      setErrorMessage('Employee ID is required');
      return;
    }

    if (password === '') {
      setErrorMessage('Password is required');
      return;
    }

    if (password.length < 6) {
      setErrorMessage('Password should be at least 6 characters long');
      return;
    }

    if (password !== confirmPassword) {
      setErrorMessage('Passwords do not match');
      return;
    }

    // create logic for mobile number is required and should be 10 digits
    // create logic for gender is required
    if (mobileNumber === '') {
      setErrorMessage('Mobile Number is required');
      return;
    }
    if (mobileNumber.length !== 10) {
      setErrorMessage('Mobile Number should be 10 digits');
      return;
    }
    if (gender === '') {
      setErrorMessage('Gender is required');
      return;
    }

    // Perform signup API call here
    // You can show loading indicator while the API call is in progress
    setIsLoading(true);
    console.log('Employee ID:', employeeId);
    console.log('Password', password);
    console.log('Confirm Password', confirmPassword);
    console.log('Confirm Password', atob(password));
    console.log('Mobile Number', mobileNumber);
    console.log('Gender', gender);

    const update = {
      name: name,
      employeeId: employeeId,
      password: 'Brilliant post on fetch API',
      mobileNumber: '9999999999',
      gender: 'Male',
    };
    // Example API call
    // signUpAPI(employeeId, password)
    //     .then(response => {
    //         setIsLoading(false);
    //         setSuccessMessage('Signup successful');
    //     })
    //     .catch(error => {
    //         setIsLoading(false);
    //         setErrorMessage('Signup failed');
    //     });

    // const update = {
    //   name: 'A blog post by Kingsley',
    //   email: 'Brilliant post on fetch API',
    //   password: 'Brilliant post on fetch API',
    //   mobileNumber: '9999999999',
    //   gender: 1,
    // };

    const options = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(update),
    };
  };

  return (
    <View style={styles.container}>
      <View style={styles.formContainer}>
        <Text style={styles.header}>Sign Up</Text>
        <Text>Name</Text>
        <TextInput
          style={styles.input}
          placeholder="Enter your Employee ID"
          value={employeeId}
          onChangeText={setEmployeeId}
        />
        <Text>Employee Id</Text>
        <TextInput
          style={styles.input}
          placeholder="Enter your Employee ID"
          value={employeeId}
          onChangeText={setEmployeeId}
        />
        <Text>Password</Text>
        <TextInput
          style={styles.input}
          placeholder="Enter your Password"
          secureTextEntry
          value={password}
          onChangeText={setPassword}
        />
        <Text>Confirm Password</Text>
        <TextInput
          style={styles.input}
          placeholder="Enter your Confirm Password"
          secureTextEntry
          value={confirmPassword}
          onChangeText={setConfirmPassword}
        />
        <Text>Mobile Number</Text>
        <TextInput
          style={styles.input}
          placeholder="Enter your Mobile Number"
          secureTextEntry
          value={mobileNumber}
          onChangeText={setMobileNumber}
        />
        <Text>Gender</Text>
        <Dropdown
          data={genderData}
          value={gender}
          onChange={setGender}
          labelField="label"
          valueField="value"
          style={styles.input}
        />
        {errorMessage !== '' && (
          <Text style={styles.error}>{errorMessage}</Text>
        )}
        {successMessage !== '' && (
          <Text style={styles.success}>{successMessage}</Text>
        )}
        {isLoading && <Text style={styles.loading}>Loading...</Text>}

        <Button mode="contained" onPress={handleSignUp}>
          Sign Up
        </Button>
      </View>
    </View>
  );
};

const styles = {
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'grey',
  },
  formContainer: {
    borderRadius: 5,
    width: '80%',
    padding: 10,
    backgroundColor: 'white',
  },
  input: {
    borderWidth: 1,
    borderRadius: 5,
    padding: 10,
    margin: 5,
  },
  error: {
    color: 'red',
  },
  success: {
    color: 'green',
  },
  loading: {
    color: 'blue',
  },
  button: {
    backgroundColor: 'blue',
    padding: 10,
    margin: 5,
    borderRadius: 5,
  },
  header: {
    fontSize: 20,
    fontWeight: 'bold',
    marginBottom: 10,
    alignSelf: 'center',
  },
};

export default SignUp;
