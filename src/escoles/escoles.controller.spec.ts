import { Test, TestingModule } from '@nestjs/testing';
import { EscolesController } from './escoles.controller';

describe('EscolesController', () => {
  let controller: EscolesController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [EscolesController],
    }).compile();

    controller = module.get<EscolesController>(EscolesController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
