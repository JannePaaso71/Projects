import { useCallback } from 'react';

export default function useToggleCallback(dispatch) {
    const toggle = useCallback(
        (id) => {
            dispatch({ type: 'TOGGLE', payload: id });
        },
        [dispatch]
    );

    return toggle;
}