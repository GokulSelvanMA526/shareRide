/*
create an react native screen for login with following fields:
1. email
2. password
3. login button
4. signup button

use the elements from react-native and react-native-vector-icons libraries:
1. View
2. Text
3. TextInput
4. Button
5. ActivityIndicator
6. Icon

follow the given structure:
1. create a container with styles
2. create form container with styles
3. create email input field with styles inside form container
4. create password input field with styles inside form container
5. create login button with styles inside form container
6. create signup button with styles inside form container
7. create error message with styles below email input field and password input field
8. create success message with styles below login button
9. create loading indicator with styles below login button
10. place the form container inside the container and center of the screen
11. create form container background color as white
use the following state variables:
1. email
2. password

use icon for email and password input fields:
1. email: <Icon name="email" size={20} color="black" />
2. password: <Icon name="password" size={20} color="black" />
3. login: <Icon name="login" size={20} color="black" />

use the following functions:
1. setEmail
2. setPassword
3. login

use the following validations:
1. email should be a valid email
2. password should be atleast 6 characters long
3. show error message if email or password is invalid below the respective input field
4. show error message if login api fails
5. show error message if signup api fails
6. show loading indicator while api is in progress
7. show success message on successful login or signup
8. show error message on unsuccessful login or signup
9. show error message if email or password is empty
10. show error message if email or password is not provided
11. show error message if email or password is not a string
12. show error message if email or password is not provided in request
13. show error message if email or password is not provided in response
14. show error message if email or password is not a string in request
15. show error message if password is left empty in input field and login is clicked without entering password in input field and vice versa below the password input field
16. show error message if email is left empty in input field and login is clicked without entering email in input field below the email input field

use the following styles:
container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'lightgrey',
},
formContainer: {
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
button: {
    backgroundColor: 'blue',
    padding: 10,
    margin: 5,
    borderRadius: 5,
},
error: {
    color: 'red',
},
success: {
    color: 'green',
},

*/

import React, {useState} from 'react';
import {
  View,
  Text,
  TextInput,
  Button,
  ActivityIndicator,
  StyleSheet,
} from 'react-native';
// import Icon from 'react-native-vector-icons/FontAwesome';
// import Icon from '../../components/Icon';
// import {MaterialIcon} from '../../components/Micon';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');

  const handleLogin = () => {
    // Perform login logic here
    setLoading(true);
    setError('');
    setSuccess('');

    // Validate email and password
    if (!email || !password) {
      setError('Please enter email and password');
      setLoading(false);
      return;
    }

    if (typeof email !== 'string' || typeof password !== 'string') {
      setError('Email and password must be strings');
      setLoading(false);
      return;
    }

    if (!email.includes('@') || !email.includes('.')) {
      setError('Invalid email');
      setLoading(false);
      return;
    }

    if (password.length < 6) {
      setError('Password must be at least 6 characters long');
      setLoading(false);
      return;
    }

    // Simulate API call
    setTimeout(() => {
      setLoading(false);
      setSuccess('Login successful');
    }, 2000);
  };

  return (
    <View style={styles.container}>
      <View style={styles.formContainer}>
        <TextInput
          style={styles.input}
          placeholder="Email"
          value={email}
          onChangeText={setEmail}
        />
        <TextInput
          style={styles.input}
          placeholder="Password"
          secureTextEntry
          value={password}
          onChangeText={setPassword}
        />
        {error ? <Text style={styles.error}>{error}</Text> : null}
        {success ? <Text style={styles.success}>{success}</Text> : null}
        {loading ? <ActivityIndicator size="small" color="blue" /> : null}
        <Button title="Login" onPress={handleLogin} />
        <Button title="Signup" onPress={() => {}} />
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'lightgrey',
  },
  formContainer: {
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
  button: {
    backgroundColor: 'blue',
    padding: 10,
    margin: 5,
    borderRadius: 5,
  },
  error: {
    color: 'red',
    fontFamily: 'Nunito-Bold',
  },
  success: {
    color: 'green',
    fontFamily: 'Nunito-Bold',
  },
});

export default Login;
