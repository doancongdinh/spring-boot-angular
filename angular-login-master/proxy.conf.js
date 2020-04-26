const PROXY_CONFIG = [
  {
    context: [
      "/test",
    ],
    target: "http://localhost:8081",
    changeOrigin: true,
    logLevel: "debug",
    secure: false
  }
]
module.exports = PROXY_CONFIG;
