suite('Runicorn.Api', function() {
    
    setup(function(done) {
        done()
    })

    test('memory endpoint should allow save', function(done) {
        var xhr = new XMLHttpRequest()
            xhr.onreadystatechange = function() {
                if (xhr.readyState == XMLHttpRequest.DONE) {
                    assert.equal(xhr.responseText, "test")
                    done()
                }
            }
            xhr.open('GET', '/memory/?remember_me=test', true)
            xhr.send(null)
    })

    test('memory_check endpoint should return saved value', function(done) {
        var xhr = new XMLHttpRequest()
            xhr.onreadystatechange = function() {
                if (xhr.readyState == XMLHttpRequest.DONE) {
                    assert.equal(xhr.responseText, "test")
                    done()
                }
            }
            xhr.open('GET', '/memory_check/', true)
            xhr.send(null)
    })
})