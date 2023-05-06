import axios from 'axios'

const req = axios.create({
    baseURL: "/api",
    timeout: 5000,
    headers: {
        "auth": localStorage.getItem('token'),
        "Content-Type": "application/json;charset=utf-8",
    }
})

export default req