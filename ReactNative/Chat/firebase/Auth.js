import { auth} from "./Config";
import { signInWithEmailAndPassword } from "firebase/auth";

export const signIn = async (email, password) => {
    try {
        const userCredential = await signInWithEmailAndPassword(auth, email, password)
        return userCredential.user
    } catch (error) {
        console.error(error)
        throw error
    }
}