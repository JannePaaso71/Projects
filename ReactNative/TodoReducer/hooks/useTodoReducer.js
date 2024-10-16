

export function todoReducer(state, action) {
    switch (action.type) {
        case 'ADD':
            return [...state, action.payload];
        case 'TOGGLE':
            return state.map(todo => {
                if (todo.id === action.payload) {
                    return {...todo, completed: !todo.completed};
                }
                return todo;
            });
        case 'DELETE':
            return state.filter(todo => todo.id !== action.payload);
        default:
            return state;
    }
}