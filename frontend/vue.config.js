const path = require("path");
const join = (...args) =>
    path.resolve(__dirname, ...args);

const host_path = process.cwd();

const current_env = process.env.NODE_ENV;


/**
 * append watch dir
 */
const {ManageTempalteWatchDir} = require("@ztwx/auto-template");

if (current_env === "dev") new ManageTempalteWatchDir().watch(path.join(host_path, "src"));

module.exports = {
    productionSourceMap: false,
    chainWebpack: config => {
        //环境配置
        // config.resolve.alias
        //     .set("@config",join("src/envs/config.dev.ts"));
        config.resolve.alias
            .set("@config", join(`src/envs/config.${current_env}.ts`))
            .set("@ice", join("src/ice.ts"))
            .set("@types", join("src/components/types/types.ts"))
            .set("@req", join("src/requests"));

        config.module
            .rule("fonts")
            .use("url-loader")
            .loader("url-loader")
            .tap(opt => ({...opt, limit: 1}));

        config.plugins.delete("prefetch");
        config.plugins.delete("preload");
        // config.plugins.delete("extract-css");

    },
    pages: {
        index: {
            entry: "src/shop/main.ts",
            template: "public/index.html",
            filename: "index.html",
            title: "Health Products",
           
        },
        manage: {
            entry: "src/main.ts",
            template: "public/manage.html",
            filename: "manage.html",
            title: "后台管理"
        },

    },
    devServer: {
        proxy: {
            '/devTest': {
                /* 目标代理服务器地址 */
                target: 'http://localhost:8806',
                /* 允许跨域 */
                changeOrigin: true,
                pathRewrite: {"^/devTest": ""}
            },
        },
    },
};
