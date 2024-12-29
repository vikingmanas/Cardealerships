// Array to store users (with localStorage persistence)
let users = JSON.parse(localStorage.getItem('users')) || [];

// Function to validate the form and check if passwords match
function validateForm() {
    const username = document.getElementById('username').value.trim();
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value.trim();
    const confirmPassword = document.getElementById('confirmPassword').value.trim();

    if (password !== confirmPassword) {
        alert("Passwords do not match!");
        return false;
    }
    
    // Check if fields are empty
    if (!username || !email || !password) {
        alert("All fields are required!");
        return false;
    }

    // Check if username or email already exists
    if (users.some(user => user.username === username || user.email === email)) {
        alert("Username or Email already exists!");
        return false;
    }

    return true;
}

// Function to handle form submission and adding user to the table
document.getElementById('userForm').addEventListener('submit', function(e) {
    e.preventDefault();
    
    if (!validateForm()) {
        return;
    }

    const username = document.getElementById('username').value.trim();
    const email = document.getElementById('email').value.trim();
    
    // Create a new user object
    const newUser = { username, email };

    // Add the user to the users array
    users.push(newUser);

    // Save to localStorage
    localStorage.setItem('users', JSON.stringify(users));

    // Clear the form fields
    document.getElementById('userForm').reset();

    // Display the updated user list
    displayUsers();
});

// Function to display users in the table
function displayUsers() {
    const userTableBody = document.getElementById('userTableBody');
    userTableBody.innerHTML = '';

    users.forEach((user, index) => {
        const row = document.createElement('tr');
        
        const usernameCell = document.createElement('td');
        usernameCell.textContent = user.username;
        row.appendChild(usernameCell);

        const emailCell = document.createElement('td');
        emailCell.textContent = user.email;
        row.appendChild(emailCell);

        const actionsCell = document.createElement('td');
        actionsCell.innerHTML = `<button class="btn btn-danger" onclick="deleteUser(${index})">Delete</button>`;
        row.appendChild(actionsCell);

        userTableBody.appendChild(row);
    });
}

// Function to delete a user
function deleteUser(index) {
    const confirmation = confirm("Are you sure you want to delete this user?");
    if (confirmation) {
        users.splice(index, 1); // Remove the user from the array
        localStorage.setItem('users', JSON.stringify(users)); // Update localStorage
        displayUsers(); // Re-render the user table
    }
}

// Initialize the user table on page load
window.onload = displayUsers;
