import axios from 'axios'

const req = axios.create({
    baseURL: "http://127.0.0.1/api",
    timeout: 5000,
    headers: {
        "auth": localStorage.getItem('token'),
        "Content-Type": "application/json;charset=utf-8"
    }
})

export default req