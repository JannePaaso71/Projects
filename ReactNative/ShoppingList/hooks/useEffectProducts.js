import {useEffect, useState} from "react";
import {collection, firestore, MESSAGES, onSnapshot, query} from "../config/Config";


export default function useEffectProducts() {
    const [products, setProducts] = useState([])

    useEffect(() => {
        const q = query(collection(firestore, MESSAGES));
        const unsubscribe = onSnapshot(q, (querySnapshot) => {
            const tempProducts = [];
            querySnapshot.forEach((doc) => {
                tempProducts.push({...doc.data(), id: doc.id})
            })
            setProducts(tempProducts)
        })
        return () => {
            unsubscribe()
        }
    }, []);

    return products
}