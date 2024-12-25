// khởi tạo các URL API
// <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>


const baseURL = "http://localhost:8080/api_categories";

//DOM Elements

const categoryTable = document.getElementById("categoryTable").querySelector("tbody");
const categoryForm = document.getElementById("categoryForm");
const searchButton = document.getElementById("searchButton");
const searchKeyword = document.getElementById("searchKeyword");
const cateCode = document.getElementById("cateCode");
const cateName = document.getElementById("cateName");
const categoryId = document.getElementById("categoryId");

//Tải ds category

function loadCategories() {
    axios.get(baseURL)
        .then(response => {
            const categories = response.data;
            categoryTable.innerHTML = ""; //xóa dữ liệu cũ
            categories.forEach(category => {
                const row = `
                <tr>
                 <td>${category.id}</td>
                 <td>${category.cateCode}</td>
                 <td>${category.cateName}</td>
                 <td>
                <button class="btn btn-primary btn-sm" onclick="editCategory(${category.id})">Edit</button>
                <button class="btn btn-danger btn-sm" onclick="deleteCategory(${category.id})">Delete</button>
                </td>
                </tr>
                `;
                categoryTable.insertAdjacentHTML("beforeend", row);
            });
        })
        .catch(error => console.error("Error loading categories:", error));
}

document.addEventListener("DOMContentLoaded", loadCategories);
addButton.addEventListener("click", () => {
    categoryForm.style.display = "block"; // Hiển thị form
});
cancelButton.addEventListener("click", () => {
    categoryForm.style.display = "none"; // Ẩn form
});