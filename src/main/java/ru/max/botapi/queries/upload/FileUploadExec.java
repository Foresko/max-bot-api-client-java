package ru.max.botapi.queries.upload;

import java.io.File;
import java.util.Collections;
import java.util.concurrent.Future;

import ru.max.botapi.client.ClientResponse;
import ru.max.botapi.client.MaxTransportClient;
import ru.max.botapi.exceptions.ClientException;
import ru.max.botapi.exceptions.TransportClientException;

class FileUploadExec implements UploadExec {
    private final File file;
    private final String url;
    private final String accessToken;

    FileUploadExec(String url, File file, String accessToken) {
        this.url = url;
        this.file = file;
        this.accessToken = accessToken;
    }

    FileUploadExec(String url, File file) {
        this(url, file, null);
    }

    @Override
    public Future<ClientResponse> newCall(MaxTransportClient transportClient) throws ClientException,
            InterruptedException {

        try {
            return transportClient.post(
                    url,
                    file,
                    (accessToken != null) ? Collections.singletonMap("Authorization", "Bearer " + accessToken) : Collections.emptyMap()
            );
        } catch (TransportClientException e) {
            throw new ClientException(e);
        }
    }
}
