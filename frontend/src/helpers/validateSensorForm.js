export const integerValidator = () => ({
    validator(_, value) {
        if (value % 1 === 0) {
            return Promise.resolve();
        }
        return Promise.reject(new Error('An integer is expected'));
    },
});

export const rangeFromValidator = (form) => ({
    validator(_, value) {
        if (form.getFieldValue("rangeTo") > value) {
            return Promise.resolve();
        }
        return Promise.reject(new Error('RangeFrom is greater than rangeTo'));
    },
});