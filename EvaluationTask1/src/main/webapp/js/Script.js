document.addEventListener('DOMContentLoaded', function () {
    var showModal = document.getElementById('modalTrigger').getAttribute('data-show-modal') === 'true';
    if (showModal) {
        var myModal = new bootstrap.Modal(document.getElementById('staticBackdrop'));
        myModal.show();
    }
});