/**
 * Created by sx on 2016/8/12.
 */

"use strict";

/**
 * 字符串模板拼接
 * @param template
 * @param context
 * @returns {*}
 *
 */

/**
 * 示例
 *
 render('My name is {name}'， {
    name: 'hsfzxjy'
});  // My name is hsfzxjy

 render('I am in {profile.location}', {
    name: 'hsfzxjy',
    profile: {
        location: 'Guangzhou'
    }
}); // I am in Guangzhou

 render('{ greeting }. \\{ This block will not be rendered }', {
    greeting: 'Hi'
});
 */
function render(template, context) {

    var tokenReg = /(\\)?\{([^\{\}\\]+)(\\)?\}/g;

    return template.replace(tokenReg, function (word, slash1, token, slash2) {
        if (slash1 || slash2) {
            return word.replace('\\', '');
        }

        var variables = token.replace(/\s/g, '').split('.');
        var currentObject = context;
        var i, length, variable;

        for (i = 0, length = variables.length; i < length; ++i) {
            variable = variables[i];
            currentObject = currentObject[variable];
            if (currentObject === undefined || currentObject === null) return '';
        }
        return currentObject;
    })
}


/**
 * 示例
 * @param context
 * @returns {*}
 */

/**
 *
 "{greeting}! My name is { author.name }.".render({
    greeting: "Hi",
    author: {
        name: "hsfzxjy"
    }
});
 */
String.prototype.render = function (context) {
    return render(this, context);
};
