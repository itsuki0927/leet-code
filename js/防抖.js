/**
 * 
 * @param {Function} func 
 * @param {Number} wait 
 * @param {Boolean} immediate 
 */
function debounce(func, wait, immediate) {
    var timeout;
    var result;

    var debounced = function () {
        var _this = this
        var args = arguments
        var callNow

        if (timeout) clearTimeout(timeout)

        if (immediate) {
            callNow = !timeout

            timeout = setTimeout(function () {
                timeout = null
            }, wait)

            if (callNow) result = func.apply(_this, args)

        } else {
            timeout = setTimeout(function () {
                func.apply(_this, args)
            }, wait);
        }
        return result;
    }

    debounced.cancel = function () {
        clearTimeout(timeout)
        timeout = null
    }

    return debounced
}