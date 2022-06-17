document.addEventListener('DOMContentLoaded', function() {
    let modalButtons = document.querySelectorAll('.js-open-modal'),
        overlay      = document.querySelector('.js-overlay-modal'),
        closeButtons = document.querySelectorAll('.js-modal-close');
    modalButtons.forEach(function(item){
        item.addEventListener('click', function(e) {
            e.preventDefault();

            let modalId = this.getAttribute('data-modal'),
                modalElem = document.querySelector('.modal[data-modal="' + modalId + '"]');

            modalElem.classList.add('active');
            overlay.classList.add('active');
        });
    });
    closeButtons.forEach(function(item){
        item.addEventListener('click', function() {
            let parentModal = this.closest('.modal');
            parentModal.classList.remove('active');
            overlay.classList.remove('active');
        });
    });

    document.body.addEventListener('keyup', function (e) {
        let key = e.keyCode;
        if (key === 27) {
            document.querySelector('.modal.active').classList.remove('active');
            document.querySelector('.overlay').classList.remove('active');
        }
    }, false);

    overlay.addEventListener('click', function() {
        document.querySelector('.modal.active').classList.remove('active');
        this.classList.remove('active');
    });

    document.querySelector(".button-shadow").addEventListener('click', submitClicked)
    function submitClicked() {
        let cartItems = document.getElementsByClassName('cart-items')[0]
        if(cartItems.hasChildNodes()) {
            let field = document.getElementsByClassName('goods')[0]
            field.value = ""
            cartItems.removeChild(cartItems.firstChild)
            while (cartItems.hasChildNodes()) {
                let title = cartItems.getElementsByClassName('cart-item-title')[0].innerText
                let price = cartItems.getElementsByClassName('cart-price')[0].innerText.replace("$", "")
                price = parseFloat(price)
                let number = cartItems.getElementsByClassName('cart-quantity-input')[0].value
                field.value += title + "-" + price + "-" + number + ";"
                cartItems.removeChild(cartItems.firstChild)
            }
            updateCartTotal()
        }
        if(cartItems.childElementCount === 0) {
            let purchaseButton = document.getElementsByClassName("btn-purchase")[0]
            purchaseButton.style.visibility = "hidden"
        }
    }
});