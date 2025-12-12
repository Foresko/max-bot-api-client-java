package ru.max.botapi.queries.upload;

import java.io.InputStream;
import java.util.Collections;
import java.util.concurrent.Future;

import ru.max.botapi.client.ClientResponse;
import ru.max.botapi.client.MaxTransportClient;
import ru.max.botapi.exceptions.ClientException;
import ru.max.botapi.exceptions.TransportClientException;

class StreamUploadExec implements UploadExec {
    private final String fileName;
    private final InputStream input;
    private final String url;
    private final String accessToken;

    StreamUploadExec(String url, String fileName, InputStream input, String accessToken) {
        this.url = url;
        this.fileName = fileName;
        this.input = input;
        this.accessToken = accessToken;
    }

    StreamUploadExec(String url, String fileName, InputStream input) {
        this(url, fileName, input, null);
    }

    @Override
    public Future<ClientResponse> newCall(MaxTransportClient transportClient) throws ClientException {
        try {
            return transportClient.post(url,
                    fileName,
                    input,
                    (accessToken != null) ? Collections.singletonMap("Authorization", accessToken) : Collections.emptyMap()
            );
        } catch (TransportClientException e) {
            throw new ClientException(e);
        }
    }
}
