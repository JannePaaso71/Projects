import { StyleSheet, Text, useColorScheme, View } from 'react-native';
import { Button, PaperProvider } from 'react-native-paper';
import MyAppbar from './components/MyAppbar';
import { customLightTheme, customDarkTheme } from './theme/AppTheme';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { NavigationContainer } from '@react-navigation/native';
import HomeScreen from './screens/HomeScreen';
import SecondScreen from './screens/SecondScreen';

export default function App() {
    const colorScheme = useColorScheme();
    const myTheme = colorScheme === 'dark' ? customDarkTheme : customLightTheme;
    const Stack = createNativeStackNavigator();

    return (
        <PaperProvider theme={myTheme}>
            <NavigationContainer>
                <Stack.Navigator
                    initialRouteName="Home"
                    screenOptions={({ navigation, route }) => ({
                        header: (props) => (
                            <MyAppbar
                                {...props}
                                navigation={navigation}
                                back={route.name !== 'Home'}
                            />
                        ),
                    })}
                >
                    <Stack.Screen
                        name="Home"
                        component={HomeScreen}
                        options={{
                            title: 'Home',
                        }}
                    />
                    <Stack.Screen
                        name="Second"
                        component={SecondScreen}
                        options={{
                            title: 'Second',
                        }}
                    />
                </Stack.Navigator>
            </NavigationContainer>
        </PaperProvider>
    );
}