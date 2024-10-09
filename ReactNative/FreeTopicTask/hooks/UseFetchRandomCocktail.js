import { useState, useEffect } from 'react'

const URL = 'https://www.thecocktaildb.com/api/json/v1/1/random.php'

const useFetchRandomCocktail = () => {
    const [cocktail, setCocktail] = useState('cocktails')
    const [cocktailImage, setCocktailImage] = useState(null)
    const [loading, setLoading] = useState(false)
    const [error, setError] = useState(null)

    useEffect(() => {
        getCocktailData()
        //setError(null)
    }, []);

    const getCocktailData = async () => {
        setLoading(true)
        try {
            //throw new Error("Error for testing");
            const response = await fetch(URL)
            if(response.ok) {
                const json = await response.json()
                if (json.drinks && json.drinks.length > 0) {
                    setCocktail(json.drinks[0].strDrink);
                } else {
                    setError('No cocktail found')
                }

            } else {
                setError('Error fetching data')
            }
        } catch (error) {
            setError(error.message)
        }
        setLoading(false)
    }
    return {cocktail, cocktailImage, loading, error, getCocktailData, setError}
}

export default useFetchRandomCocktail;