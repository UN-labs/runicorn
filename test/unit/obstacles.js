suite('Runicorn.Obstacles', function() {
    
    setup(function(done) {
        game_speed = 2.5
        the_obstacles.push(new Obstacles())
        done()
    })

    test('obstacle should have x of 600', function() {
        assert.equal(the_obstacles[0].x, 600)
    })

    test('obstacle should have y of 128', function() {
        assert.equal(the_obstacles[0].y, 128)
    })

})