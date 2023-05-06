import req from './req'

export const login = (data) => req({ method: "POST", url: "/login", data })