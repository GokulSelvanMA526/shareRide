/*
create an typescript functional component called Icon:
- should accept a name prop of type string
- should accept size as IconSize enum with values 'small: 13', 'medium:18', 'large:23', 'xlarge:37'
- should accept color as IconColor enum with values 'black', 'blue', 'red'

Hint: You can use the following enums:
enum IconSize {
  small = 13,
  medium = 18,
  large = 23,
  xlarge = 37,
}

enum IconColor {
  black = 'black',
  blue = 'blue',
  red = 'red',
}

Hint: You can use the following props interface:
interface IconProps {
  name: string;
  size: IconSize;
  color: IconColor;
}

Hint: You can use the following import statement:
import React from 'react';
import { View, Text } from 'react-native';

Hint: You can use the following Icon component:
- use MIcon from 'react-native-vector-icons/MaterialCommunityIcons'

initial code:
MIcon.loadFont();

*/

import React from 'react';
import {View} from 'react-native';
import MIcon from 'react-native-vector-icons/MaterialCommunityIcons';

enum IconSize {
  small = 13,
  medium = 18,
  large = 23,
  xlarge = 37,
}

enum IconColor {
  black = 'black',
  blue = 'blue',
  red = 'red',
}

interface IconProps {
  name: string;
  size: IconSize;
  color: string;
}

MIcon.loadFont();
const Icon: React.FC<IconProps> = ({name, size, color}) => {
  return (
    <View>
      <MIcon name={name} size={size} color={color} />
    </View>
  );
};

export default Icon;
