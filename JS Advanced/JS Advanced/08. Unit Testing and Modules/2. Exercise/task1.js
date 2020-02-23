function solve(request) {
    let [method, uri, version, message] = ['method', 'uri', 'version', 'message'];
    let [Method, URI, Version, Message] = ['Method', 'URI', 'Version', 'Message'];
    const methodValues = ["GET", "POST", "DELETE", "CONNECT"];
    const versions = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];

    let validate= (function () {
        let ifError = test();

        function methodOf(request) {
            ifError(!request.hasOwnProperty(method), Method);
            ifError(!methodValues.includes(request.method), Method);
        }

        function uriOf(request) {
            ifError(!request.hasOwnProperty(uri), URI);
            ifError(!/^[a-zA-Z0-9.]+$/g.test(request.uri), URI);
            ifError(request.uri === "*", URI);
        }

        function versionOf(request) {
            ifError(!request.hasOwnProperty(version), Version);
            ifError(!versions.includes(request.version), Version);
        }

        function messageOf(request) {
            ifError(!request.hasOwnProperty(message), Message);
            ifError(!/^[^<>\\&'"]*$/g.test(request.message), Message);
        }

        function test() {
            return function (expression, property) {
                if (expression) {
                    throw new Error(`Invalid request header: Invalid ${property}`);
                }
            }
        }

        return {methodOf, uriOf, versionOf, messageOf};
    })()

    validate.methodOf(request);
    validate.uriOf(request);
    validate.versionOf(request);
    validate.messageOf(request);
    
    return request;
    
}

console.log(
    solve(
        {
            method: 'POST',
            uri: 'home.bash',
            message: 'rm -rf /*'
          }
    )
)