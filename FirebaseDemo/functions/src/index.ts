import * as functions from 'firebase-functions';
import * as admin from 'firebase-admin';
import * as cors from 'cors';

const corsHandler = cors({origin: true});
admin.initializeApp();

export const getDataByCountry= functions.https.onRequest(async (request, response) => {
    corsHandler(request, response, () => {
        console.log(request);
        admin.firestore().collection('Summary').doc(request.body.data.data).get()
            .then(value => {
                const data = value.data();
                response.send({data: data});
            })
            .catch(error => {
                console.log(error);
                response.status(500).send(error);
            })
    });
});

export const onBostonWeatherUpdate = functions.firestore.document('Summary').
