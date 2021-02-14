const path = require('path');

module.exports = {
  entry: './src/js/index.js',
  output: {
    filename: 'main.js',
    path: path.resolve(__dirname, 'dist'),
  },
  mode: 'development',
  devtool: 'inline-source-map',
  devServer: {
      contentBase: path.resolve(__dirname, 'dist'),
      compress:true,
      port:8080,
      historyApiFallback: {
        index: '/'
      },
      watchContentBase: true
  }
};