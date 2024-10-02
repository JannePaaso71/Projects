import { StyleSheet}   from "react-native"
import MapView, {Marker} from "react-native-maps"
import {useState} from "react";

export default function Map(props) {
    const [markers, setMarkers] = useState([])

    const showMarker = (e) => {
        const coords = e.nativeEvent.coordinate
        setMarkers([...markers, coords])
    }

    return (
        <MapView
            style={styles.map}
            region={props.location}
            mapType='satellite'
            onLongPress={showMarker}
        >
                    {markers.map((marker, index) => (
                        <Marker
                            key={index}
                            title={"My marker $(index + 1)"}
                            coordinate={{latitude: marker.latitude, longitude: marker.longitude}}
                        />
                    ))}
        </MapView>
    );
}

const styles = StyleSheet.create({
    map: {
        height: "100%",
        width: "100%"
    }
})