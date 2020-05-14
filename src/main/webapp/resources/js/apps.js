document.addEventListener("DOMContentLoaded", function () {
// USER INPUT DATA ELEMENTS
    let bags = document.getElementById("bags");
    let street = document.getElementById("street");
    let city = document.getElementById("city");
    let zipCode = document.getElementById("zip-code");
    let phone = document.getElementById("phone");
    let date = document.getElementById("date");
    let time = document.getElementById("time");
    let comment = document.getElementById("comment");
// CHECKBOXES AND RADIOBTNS
    let institution = "";
    let categories = [];
    institution = chosenInstitution();
    categories = categoriesArray();

// BUTTONS
    let categoriesBtn = document.querySelector(".btn.next-step.first-slide");
    let institutionBtn = document.querySelector(".btn.next-step.third-slide");
    let confirmationBtn = document.querySelector(".btn.next-step.forth-slide");
// EVENT LISTENERS
    categoriesBtn.addEventListener("click", categoriesArray);
    institutionBtn.addEventListener("click", chosenInstitution);
    confirmationBtn.addEventListener("click", displayElements);

// FUNCTIONS
// categories
    function categoriesArray() {
        let checkboxes = document.querySelectorAll(".form-group.form-group--checkbox.products");
        checkboxes.forEach(chosenCategoriesArray);

        function chosenCategoriesArray(el) {
            let checkbox = el.firstElementChild.firstElementChild;
            if (checkbox.checked) {
                let checkedCategory = checkbox.parentElement.lastElementChild;
                let checkedCategoryName = checkedCategory.innerText;
                categories.push(checkedCategoryName);
            }
        }

        return categories;
    }

//institutions
    function chosenInstitution() {
        let checkboxes = document.querySelectorAll(".form-group.form-group--checkbox.institution");
        for (let i = 0; i < checkboxes.length; i++) {
            let checkbox = checkboxes[i].firstElementChild.firstElementChild;
            if (checkbox.checked) {
                let checkedInstitution =
                    checkbox.nextElementSibling.nextElementSibling.firstElementChild;
                institution = checkedInstitution.innerText;
                break;
            }
        }
        return institution;
    }

//display elements in summary function
    function displayElements() {
        //elements in summary
        let bagsSummary = document.getElementById("bags-summary");
        let institutionSummary = document.getElementById("institution-sum");
        let streetSummary = document.getElementById("street-sum");
        let citySummary = document.getElementById("city-sum");
        let zipCodeSummary = document.getElementById("zip-code-sum");
        let phoneSummary = document.getElementById("phone-sum");
        let dateSummary = document.getElementById("data-sum");
        let timeSummary = document.getElementById("time-sum");
        let commentSummary = document.getElementById("comment-sum");

        //bags name display singular/plural(s)
        let bagName = " worek";
        if (bags.value > 1 && bags.value < 5) {
            bagName = " worki";
        }
        if (bags.value > 4) {
            bagName = " worków";
        }
        bagsSummary.innerText = bags.value + bagName;

        //institution
        institutionSummary.innerText = institution;

        //address, date, time, ...
        streetSummary.innerText = street.value;
        citySummary.innerText = city.value;
        zipCodeSummary.innerText = zipCode.value;
        phoneSummary.innerText = phone.value;
        dateSummary.innerText = date.value;
        timeSummary.innerText = time.value;
        commentSummary.innerText = comment.value;
    }
});