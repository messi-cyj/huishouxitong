module.exports = {
    publicPath: './',
    assetsDir: 'static',
    productionSourceMap: false,
    devServer: {
        proxy: {
            '/api':{
                // target:'http://192.168.11.105:15465',
                target:'http://192.168.1.37:9000',
                changeOrigin:true,
                pathRewrite:{
                    "^/api": ""
                }
            }
        }
    }
}