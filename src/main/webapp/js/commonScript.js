/* Index page */


//add row links to the table of medicines
document.addEventListener("DOMContentLoaded", () => {
    const rows = document.querySelectorAll("li[data-href]");
    rows.forEach(row => {
        row.addEventListener("click", () => {
            window.location.href = row.dataset.href;
        });
    });
});


/* Medicine product */


//add medicine product to user's shopping cart
for (let form of document.getElementsByClassName('addToCartForm')) {
    form.addEventListener('submit', async function (event) {
        if (this.elements['isLoggedIn'].value === 'true') {
            event.preventDefault();
            let medicineProductId = this.elements['medicine_product_id'].value;
            let url = "dispatcher?command=add_to_cart&medicine_product_id=" + medicineProductId;
            await fetch(url);
        }
    });
}