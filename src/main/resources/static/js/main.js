const btnConvert = $('#btnConvert');
const longUrlInput = $('#longUrl');
const shortUrl = $('#shorten-url');

const initEvent = () => {
    btnConvert.on('click', () => {
        const longUrl = longUrlInput.val();
        if (!longUrl) return;
        let shortenUrl = `/api/v1/data/shorten`;
        console.log(longUrl);
        let formData = new FormData();
        formData.append('longUrl', longUrl);
        $.ajax(shortenUrl,
            {
                type: 'POST',
                data: formData,
                contentType: false,
                processData: false,
                success: ({data: {shortUrl}}, status) => {
                    const {window: {location: {protocol, host}}} = window;
                    $('#shorten-url').html(`
                    ShortenUrl: <a href="/${shortUrl}" target="_blank">
                        ${protocol}//${host}/${shortUrl}
                    </a>`)
                },
                error: (xhr, status, error) => {
                    console.error(error);
                }
            });
    })
}

$(document).ready(() => {
    initEvent();
})