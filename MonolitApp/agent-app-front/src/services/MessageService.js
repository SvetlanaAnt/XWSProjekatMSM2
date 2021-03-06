import HttpBaseClient from './HttpBaseClient';

const FINALPOINTS = {
    MSG_BASE: '/msg',
    CONV_BASE: '/conv'
};

class MessageService extends HttpBaseClient {

    sendMessage = async payload => {
        try {
            const response = await this.getApiClient().post(
                FINALPOINTS.MSG_BASE,
                payload,
                {
                    headers: {
                        'Content-Type': 'application/json;charset=UTF-8'
                    }
                }
            );
            return response.data;

        } catch (error) {
            return error.response.data;
        }
    };

    fetchConversationMessages = async payload => {
        try {
            const response = await this.getApiClient().get(
                FINALPOINTS.CONV_BASE + '/' + payload + '/msg'
            );
            return response.data;
        } catch (error) {
            return error.response.data;
        }
    };

    fetchConversations = async payload => {
        try {
            const response = await this.getApiClient().get(
                FINALPOINTS.CONV_BASE + '/user'
            );
            return response.data;
        } catch (error) {
            return error.response.data;
        }
    };

    sendFirstMessage = async payload => {
        try {
            const response = await this.getApiClient().post(
                FINALPOINTS.MSG_BASE + '/first',
                payload,
                {
                    headers: {
                        'Content-Type': 'application/json;charset=UTF-8'
                    }
                }
            );
            return response.data;

        } catch (error) {
            return error.response.data;
        }
    };



};

export default new MessageService();