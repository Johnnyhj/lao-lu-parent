"use strict";

/**
 * 表格分页类
 * @param options
 * @constructor
 */
function Pageination(options) {
    options = options || {};

    var currentPage = options.currentPage;
    var totalPages = options.totalPages;

    if('undefined' == typeof currentPage || 'undefined' == typeof totalPages || parseInt(currentPage) > parseInt(totalPages)) {
        return;
    }


    var $page = $('#' + (options.page || 'page'));
    var $queryForm = $('#' + (options.queryForm || 'frm'));
    var $pageObject = $('#' + (options.object || 'example'));
    var $toPageText = $('#' + (options.toPageText || 'toPageText'));
    var $toPageBtn = $('#' + (options.toPageBtn || 'toPageBtn'));

    var options = {

        bootstrapMajorVersion: 3,
        currentPage: currentPage,
        numberOfPages: 5,
        totalPages: totalPages,
        onPageClicked: function (e, originalEvent, type, page) {
            $page.val(page);
            $queryForm.submit();
        }
    };

    $pageObject.bootstrapPaginator(options);

    //指定页数跳转
    $toPageBtn.click(function() {
        $page.val($toPageText.val());
        $queryForm.submit();
    });
}
