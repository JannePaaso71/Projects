import {SafeAreaView, ScrollView, Text, TextInput, View, TouchableOpacity} from 'react-native';
import styles from "./styles/Styles";
import {useState} from "react";
import  {firestore, collection, addDoc, MESSAGES, serverTimestamp, doc, deleteDoc, updateDoc} from "./config/Config";
import MyAppBar from "./components/MyAppBar";
import MyBottomBar from "./components/MyBottomBar";
import { FontAwesome } from '@expo/vector-icons';
import useEffectProducts from "./hooks/useEffectProducts";

export default function App() {
    const [newProduct, setNewProduct] = useState('')
    const products = useEffectProducts();
    const totalProducts = products.length;
    const collectedProducts = products.filter(product => product.collected).length;

  const addProductToShoppingList = async () => {
      try {
          const docRef = await addDoc(collection(firestore, MESSAGES), {
              text: newProduct,
              createdAt: serverTimestamp(),
              collected: false
          }).catch(error => console.log(error))
          setNewProduct('');
      } catch (error) {
          console.log(error)
      }
  }

    const toggleCollected = async (id, currentState) => {
        try {
            await updateDoc(doc(firestore, MESSAGES, id), {
                collected: !currentState,
            });
        } catch (error) {
            console.log("Error updating product:", error);
        }
    };

    const deleteProduct = async (id) => {
      try {
            await deleteDoc(doc(firestore, MESSAGES, id))
      } catch (error) {
          console.log(error)
      }
  }

  return (
      <SafeAreaView style={styles.container}>
          <MyAppBar/>
        <View style={styles.form}>
          <TextInput
              style={styles.textInput}
            placeholder= 'Add new product'
            value={newProduct}
            onChangeText={text => setNewProduct(text)}
            />
            <TouchableOpacity style={styles.addButton} onPress={addProductToShoppingList}>
                <Text style={styles.addButtonText}>Add</Text>
            </TouchableOpacity>
        </View>
          <ScrollView>
              {products.map((product) => (
                  <View key={product.id} style={styles.form}>
                      <TouchableOpacity onPress={() => toggleCollected(product.id, product.collected)} style={{ flex: 1 }}>
                          <Text
                              style={[styles.text, product.collected && styles.collectedText,]}>{product.text}
                          </Text>
                      </TouchableOpacity>
                      <TouchableOpacity onPress={() => deleteProduct(product.id)}>
                            <FontAwesome name="trash" size={24} color="black" />
                      </TouchableOpacity>
                  </View>
              ))}
          </ScrollView>
          {totalProducts > 0 && (
              <MyBottomBar
                  totalProducts={totalProducts}
                  collectedProducts={collectedProducts}
              />
          )}
      </SafeAreaView>
  )
}