const path = require( 'path' );

module.exports = {

    mode: 'production',

    entry: './src/*',

    output: {
        path: path.resolve( __dirname, 'dist' ),
        filename: 'main.js',
    },

    resolve: {
        extensions: [ '.js' ],
    },

    module: {
        rules: [
            {
                test: /\.tsx?/,
                use: 'ts-loader',
                exclude: /node_modules/,
            }
        ]
    }
};