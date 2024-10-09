import React  from "react";
import {Text, View, ActivityIndicator} from "react-native";
import {styles} from "../styles/Style";

const LoadingCocktail = ({cocktail, loading}) => {
    return (
        <View style={styles.cocktailContainer}>
            {
                loading ? (
                    <ActivityIndicator size="large" color="#0000ff" />
                ) : (
                    <Text style={styles.cocktailText}>{cocktail}</Text>
                )
            }
        </View>
    )
}

export default LoadingCocktail;