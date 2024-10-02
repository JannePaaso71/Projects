import * as Location from 'expo-location';

const getUserPosition = async (setLocation) => {
    let { status } = await Location.requestForegroundPermissionsAsync();

    try {
        if (status !== 'granted') {
            console.log('Geolocation permission denied');
            return;
        }
        const position = await Location.getCurrentPositionAsync({ accuracy: Location.Accuracy.High });
        console.log("Current Position:", position.coords);
        setLocation({
            latitude: position.coords.latitude,
            longitude: position.coords.longitude,
            latitudeDelta: 0.0922,
            longitudeDelta: 0.0421,
        });
    } catch (error) {
        console.log("Error getting location", error);
    }
}

export { getUserPosition };
