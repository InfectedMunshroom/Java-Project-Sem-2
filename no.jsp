
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StegoChat</title>
    <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #18191A;
                color: #FFFFFF;
                transition: background-color 0.3s, color 0.3s;
            }
    
            body.dark-mode {
                background-color: #000000;
                color: #BFBFBF;
            }
    
            header, main, footer {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 1rem;
                background-color: #242526;
                color: #FFFFFF;
            }
    
            .logo, .profile, .icons, .icon {
                margin-right: 1rem;
            }
    
            .logo {
                font-size: 1.5rem;
                cursor: pointer;
                color: #4CAF50;
            }
    
            main {
                display: flex;
                align-items: stretch;
                margin: 1rem;
            }
    
            .contacts, .chat {
                flex: 1;
            }
    
            .chat-header, .contact-info {
                display: flex;
                align-items: center;
                padding: 0.5rem;
                background-color: #2E2F30;
                color: #FFFFFF;
            }
    
            .contact-avatar, .message-input textarea {
                width: 40px;
                height: 40px;
                border-radius: 50%;
                background-color: #2196F3;
                color: #FFFFFF;
                display: flex;
                justify-content: center;
                align-items: center;
                margin-right: 1rem;
            }
    
            .message {
                position: relative;
                background-color: #4CAF50;
                color: #FFFFFF;
                padding: 10px;
                margin-top: 10px;
                margin-bottom: 10px;
                border-radius: 8px;
                cursor: pointer;
                transition: background-color 0.3s;
                width: 50%;
                align-self: flex-end;
            }
    
            .message:hover {
                background-color: #43A047;
            }
    
            .message-options {
                position: absolute;
                top: 0;
                right: 0;
                display: none;
                gap: 5px;
            }
    
            .message:hover .message-options {
                display: flex;
            }
    
            .message-input {
                display: flex;
                align-items: center;
                padding: 1rem;
                background-color: #2E2F30;
            }
            
            .message-input textarea {
                border: 1px solid #4CAF50;
                border-radius: 8px;
                padding: 0.5rem;
                margin-right: 0.5rem;
                width: calc(100% - 1.5rem); 
                resize: none;
                box-sizing: border-box;
            }
            
            .stego-btn, .send-btn {
                padding: 0.5rem;
                background-color: #2196F3;
                color: #FFFFFF;
                border: none;
                cursor: pointer;
            }
    
            .stego-key {
                font-size: 1.5rem;
                cursor: pointer;
            }
    
            footer {
                background-color: #242526;
            }
    
            nav {
                display: flex;
            }
    
            .icon {
                margin: 0 1rem;
                cursor: pointer;
            }
    
            .icon:hover {
                color: #4CAF50;
            }
    
            .stego-popup {
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                padding: 2rem;
                background-color: #2E2F30;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
                display: none;
                color: #FFFFFF;
            }
    
            .close-popup {
                position: absolute;
                top: 10px;
                right: 10px;
                cursor: pointer;
                color: #FFFFFF;
            }
    
            .slider-container {
                position: fixed;
                top: 20px;
                right: 20px;
                display: flex;
                align-items: center;
            }
    
            .slider-label {
                margin-right: 0.5rem;
                color: #FFFFFF;
            }
    
            .slider {
                -webkit-appearance: none;
                width: 50px;
                height: 25px;
                background-color: #4CAF50;
                outline: none;
                border-radius: 20px;
                transition: background-color 0.3s;
            }
    
            .slider::-webkit-slider-thumb {
                -webkit-appearance: none;
                appearance: none;
                width: 25px;
                height: 25px;
                background-color: #2196F3;
                border-radius: 50%;
                cursor: pointer;
                transition: background-color 0.3s;
            }
    
            .slider.dark-mode {
                background-color: #FFFFFF;
            }
    
            .slider.dark-mode::-webkit-slider-thumb {
                background-color: #2E2F30;
            }
    
            .edit-input {
                display: none;
            }
    
            .edited {
                color: #8f8980;
            }
    
            .stego-popup h3 {
                color: #7c8792;
                margin-bottom: 1rem;
            }
    
            .stego-popup p {
                margin-bottom: 1rem;
            }
    
            .stego-popup span {
                cursor: pointer;
                color: #2196F3;
            }
    
            .stego-popup span:hover {
                text-decoration: underline;
            }
    
            .encryptor-decryptor {
                display: none;
                background-color: #2E2F30;
                padding: 2rem;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                z-index: 999;
    
            }
    
            .encryptor-decryptor textarea,
            .encryptor-decryptor input,
            .encryptor-decryptor button {
                display: block;
                margin-bottom: 1rem;
            }
    
            .encryptor-decryptor button {
                padding: 0.5rem;
                background-color: #0e9a4f;
                color: #ffffff;
                border: none;
                cursor: pointer;
            }
    </style>
</head>
<body>
    <header>
        <div class="logo" onclick="toggleDarkMode()">StegoChat</div>
        <div class="profile">User Name</div>
        <div class="icons">
            <span class="icon" id="settings">Settings</span>
            <span class="icon" id="contacts">Friends</span>
            <span class="icon" id="notifications">Notifications</span>
        </div>
    </header>
    
    <main>
        <section class="chat">
            <div class="chat-header">
                <div class="contact-avatar"></div> 
                <div class="contact-info">Contact Name</div>
            </div>

            <div class="chat-messages" id="chatMessages">
                <div class="message from-friend" onclick="showOptions(this)">
                    <div class="message-sender">Friend 1</div>
                    <div class="message-text">Hey! How's it going?</div>
                    <div class="message-options">
                        <span onclick="deleteMessage(this)">Delete</span>
                    </div>
                </div>
                <div class="message from-self" onclick="showOptions(this)">
                    <div class="message-sender">You</div>
                    <div class="message-text">Hi there! It's going well.</div>
                    <div class="message-options">
                        <span onclick="deleteMessage(this)">Delete</span>
                    </div>
                </div>
            </div>

            <div class="message-input">
                <textarea id="messageInput" placeholder="Type your message..."></textarea>
                <span class="stego-key" draggable="true" onclick="openEncryptorModal()">🔑</span>
                <button class="send-btn" id="sendBtn" onclick="sendMessage()">Send</button>
            </div>
        </section>
    </main>

    <footer>
        <nav>
            <span class="icon" id="chat">Active-zone</span>
            <span class="icon" id="contactsFooter">Recents</span>
            <span class="icon" id="settingsFooter">Search</span>
        </nav>
    </footer>

    <div class="stego-popup" id="stegoPopup">
        <span class="close-popup" onclick="closeStegoPopup()">X</span>
        <h3>Steganography Encryptor/Decryptor</h3>
        <p>Drag and drop the key emoji on a message to encrypt or decrypt.</p>
    </div>

    <div class="encryptor-decryptor" id="encryptorDecryptor">
        <span class="close-popup" onclick="closeEncryptorModal()">X</span>
        <h3>Message Encryptor/Decryptor</h3>
        <form action="<%= request.getRequestURI() %>" method="post">
            <textarea id="encryptorInput" name="encryptorInput" placeholder="Enter your text message..."></textarea>
            <input type="submit" value="Encrypt">
        </form>
        <div id="outputBox">
            <%-- Output message will be displayed here --%>
            <%-- You can also display any error messages here if needed --%>
        </div>
    </div>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                initializeStegoKey();
                initializeDarkModeSlider();
                initializeMessageSending();
            });
            
                function toggleDarkMode() {
                    const body = document.body;
                    body.classList.toggle('dark-mode');
                }
        
                function initializeMessageSending() {
                    const sendBtn = document.getElementById('sendBtn');
                    const messageInput = document.getElementById('messageInput');
        
                    sendBtn.addEventListener('click', sendMessage);
                }
        
                function sendMessage() {
                    const messageInput = document.getElementById('messageInput');
                    const messageText = messageInput.value.trim();
        
                    if (messageText !== '') {
                        sendMessageToChat('You', messageText);
                        messageInput.value = '';
                    }
                }
        
                function sendMessageToChat(sender, text) {
                    const chatMessages = document.getElementById('chatMessages');
                    const message = createMessage(sender, text, getCurrentTime());
                    chatMessages.appendChild(message);
                }
        
                function createMessage(sender, text, timestamp) {
                    const message = document.createElement('div');
                    message.classList.add('message');
                    message.classList.add(sender === 'You' ? 'from-self' : 'from-friend');
                    message.onclick = function () { showOptions(this); };
        
                    const senderDiv = document.createElement('div');
                    senderDiv.classList.add('message-sender');
                    senderDiv.textContent = sender;
        
                    const textDiv = document.createElement('div');
                    textDiv.classList.add('message-text');
                    textDiv.textContent = text;
        
                    const timestampDiv = document.createElement('div');
                    timestampDiv.classList.add('timestamp');
                    timestampDiv.textContent = timestamp;
        
                    const optionsDiv = document.createElement('div');
                    optionsDiv.classList.add('message-options');
        
                    const editSpan = document.createElement('span');
                    editSpan.textContent = 'Edit';
                    editSpan.onclick = function () { editMessage(this); };
        
                    const deleteSpan = document.createElement('span');
                    deleteSpan.textContent = 'Delete';
                    deleteSpan.onclick = function () { deleteMessage(this); };
        
                    optionsDiv.appendChild(editSpan);
                    optionsDiv.appendChild(deleteSpan);
        
                    message.appendChild(senderDiv);
                    message.appendChild(textDiv);
                    message.appendChild(timestampDiv);
                    message.appendChild(optionsDiv);
        
                    return message;
                }
        
                function editMessage(element) {
                    const messageDiv = element.closest('.message');
                    const textDiv = messageDiv.querySelector('.message-text');
                    const editInput = document.createElement('textarea');
                    editInput.classList.add('edit-input');
                    editInput.value = textDiv.textContent;
        
                    const saveBtn = document.createElement('button');
                    saveBtn.textContent = 'Save';
                    saveBtn.onclick = function () {
                        textDiv.textContent = editInput.value;
                        messageDiv.classList.add('edited');
                        editInput.remove();
                        saveBtn.remove();
                    };
        
                    const cancelBtn = document.createElement('button');
                    cancelBtn.textContent = 'Cancel';
                    cancelBtn.onclick = function () {
                        editInput.remove();
                        saveBtn.remove();
                    };
        
                    messageDiv.appendChild(editInput);
                    messageDiv.appendChild(saveBtn);
                    messageDiv.appendChild(cancelBtn);
        
                    editInput.focus();
                }
        
                function deleteMessage(element) {
                    element.closest('.message').remove();
                }
        
                function showOptions(message) {
                    const options = message.querySelector('.message-options');
                    options.style.display = 'flex';
                }
        
                function getCurrentTime() {
                    const now = new Date();
                    const hours = now.getHours().toString().padStart(2, '0');
                    const minutes = now.getMinutes().toString().padStart(2, '0');
                    return `${hours}:${minutes}`;
                }
        
                function initializeStegoKey() {
                    const stegoKey = document.querySelector('.stego-key');
                    const stegoPopup = document.getElementById('stegoPopup');
        
                    stegoKey.addEventListener('dragstart', function (event) {
                        event.dataTransfer.setData('text/plain', 'stego-key');
                        stegoPopup.style.display = 'block';
                    });
        
                    document.body.addEventListener('dragover', function (event) {
                        event.preventDefault();
                    });
        
                    document.body.addEventListener('drop', function (event) {
                        event.preventDefault();
                        const data = event.dataTransfer.getData('text/plain');
                        if (data === 'stego-key') {
                            const stegoPopup = document.getElementById('stegoPopup');
                            stegoPopup.style.display = 'none';
                        }
                    });
                }
    
                function closeEncryptorModal() {
                    const encryptorModal = document.getElementById('encryptorDecryptor');
                    encryptorModal.style.display = 'none';
                }
        
                function initializeDarkModeSlider() {
                    const darkModeSlider = document.getElementById('darkModeSlider');
                    const body = document.body;
        
                    darkModeSlider.addEventListener('input', function () {
                        body.classList.toggle('dark-mode', darkModeSlider.value === '1');
                    });
                }
                
                function openEncryptorModal() {
                    const encryptorModal = document.getElementById('encryptorDecryptor');
                    encryptorModal.style.display = 'block';
                }
                
        
                function encryptMessage() {
                    const inputText = document.getElementById('encryptorInput').value;
                    const outputBox = document.getElementById('outputBox');   
                    const encryptedText = inputText.toUpperCase(); 
                    outputBox.textContent = `Encrypted Message: ${encryptedText}`;
                }
        
                function decryptMessage() {
                    const inputText = document.getElementById('encryptorInput').value;
                    const outputBox = document.getElementById('outputBox');
                    const decryptedText = inputText.toLowerCase(); 
                    outputBox.textContent = `Decrypted Message: ${decryptedText}`;
                }
        </script>


    <%
// Handle form submission
String inputText = request.getParameter("encryptorInput");
if (inputText != null && !inputText.isEmpty()) {
    try {
        String filePath = "C:\\Users\\sanya\\Downloads"; // Update the file path
        java.io.FileWriter writer = new java.io.FileWriter(filePath + "/output.txt");
        writer.write(inputText);
        writer.close();
        out.println("<p>Text file generated successfully!</p>");
    } catch (java.io.IOException e) {
        out.println("<p>Error generating text file: " + e.getMessage() + "</p>");
        e.printStackTrace(); // Log the exception for debugging
    }
}
%>

</body>
</html>
