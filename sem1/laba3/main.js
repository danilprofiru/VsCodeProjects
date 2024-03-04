const menuBtn = document.querySelector(".menu__btn");
const menuList = document.querySelector(".menu__list");
function toggleMenuVisibility() {
menuList.classList.toggle("hide");
}
menuBtn.addEventListener("click", toggleMenuVisibility);
// Скрипт для раскрытия блока portfolio
/* Открыть и закрыть кнопку */
function myFunction() {
    document.getElementById("myPortfolio").classList.toggle("show");
  }
  
  /* Закрытие меню */
  window.onclick = function(event) {
    if (!event.target.matches('.port_button')) {
      var dropdowns = document.getElementsByClassName("portfolio-content");
      var i;
      for (i = 0; i < dropdowns.length; i++) {
        var openDropdown = dropdowns[i];
        if (openDropdown.classList.contains('show')) {
          openDropdown.classList.remove('show');
        }
      }
    }
  }