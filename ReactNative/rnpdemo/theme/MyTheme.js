import { MD3DarkTheme, MD3LightTheme } from "react-native-paper";
import { Colors } from '../constants/Colors';

const customLightTheme = {...MD3LightTheme, colors: Colors.lightColors};
const customDarkTheme = {...MD3DarkTheme, colors: Colors.darkColors};

export {customLightTheme, customDarkTheme};